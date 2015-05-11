package com.bestteam.facade.presentation.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.bestteam.converter.presentation.PresentationConverter;
import com.bestteam.domain.Presentation;
import com.bestteam.dto.PresentationDto;
import com.bestteam.exception.SlideSaveException;
import com.bestteam.facade.presentation.PresentationFacade;
import com.bestteam.facade.util.FacadeConstants;
import com.bestteam.facade.util.ImageEncoder;
import com.bestteam.service.presentation.PresentationService;
import com.bestteam.service.webinar.WebinarService;

@Component("presentationFacade")
public class DefaultPresentationFacade implements PresentationFacade {

	private static final String SAVING_SLIDES_EXCEPTION_MESSAGE = "Error saving slides";

	private final static Logger LOG = LoggerFactory
			.getLogger(DefaultPresentationFacade.class);

	private final static int BUFFER_SIZE = 2048;

	@Resource
	private SessionFactory sessionFactory;

	@Resource
	private PresentationService presentationService;

	@Resource
	private PresentationConverter presentationConverter;

	@Resource
	private WebinarService webinarService;

	private FileOutputStream fileOutputStream;

	@Override
	public void save(Presentation entity) {
		presentationService.save(entity);
	}

	@Override
	public PresentationDto get(long entityId) {
		return presentationConverter.convertToDto(presentationService
				.get(entityId));
	}

	@Override
	public void update(Presentation entity) {
		presentationService.update(entity);
	}

	@Override
	public void delete(Presentation entity) {
		presentationService.delete(entity);
	}

	@Override
	public List<PresentationDto> getAll() {
		List<PresentationDto> presentationDtos = new ArrayList<PresentationDto>();

		for (Presentation presentation : presentationService.getAll()) {
			presentationDtos.add(presentationConverter
					.convertToDto(presentation));
		}

		return presentationDtos;
	}

	@Override
	public PresentationDto saveSlides(long webinarId,
			MultipartFile presentationParts) throws SlideSaveException {
		ZipInputStream zipInputStream = null;
		List<File> slides = new ArrayList<File>();
		Presentation presentation = null;

		try {
			zipInputStream = new ZipInputStream(
					presentationParts.getInputStream());

			ZipEntry entry;
			String presentationName = presentationParts.getOriginalFilename();
			if (presentationService.getPresentationByName(presentationName) == null) {
				presentation = new Presentation();
				while ((entry = zipInputStream.getNextEntry()) != null) {
					presentation.setName(presentationName);
					String filePath = MessageFormat.format(
							FacadeConstants.PRESENTATION_SLIDE_FILE_PATH,
							webinarId,
							presentationName.substring(0,
									presentationName.lastIndexOf('.')),
							entry.getName());
					byte[] buffer = new byte[BUFFER_SIZE];

					File file = new File(filePath);
					presentationService.saveSlide(file);

					try {
						fileOutputStream = new FileOutputStream(file);
						int length = 0;
						while ((length = zipInputStream.read(buffer)) > 0) {
							fileOutputStream.write(buffer, 0, length);
						}
					} finally {
						if (fileOutputStream != null)
							fileOutputStream.close();
					}
					slides.add(file);
				}

				presentation.setWebinar(webinarService.get(webinarId));
				presentation.setLocation(((File) slides.get(BigInteger.ZERO
						.intValue())).getParent());
				save(presentation);
				presentation.setContent(slides);
			}
		} catch (IOException e) {
			LOG.debug(SAVING_SLIDES_EXCEPTION_MESSAGE);
			throw new SlideSaveException(SAVING_SLIDES_EXCEPTION_MESSAGE, e);
		}

		return presentationConverter.convertToDto(presentation);
	}

	@Override
	public void loadSlides(Presentation presentation) {
		File folder = new File(presentation.getLocation());
		List<File> slides = Arrays.asList(folder.listFiles());
		presentation.setContent(slides);
	}

	@Override
	public List<PresentationDto> getPresentationsForWebinar(long webinarId) {
		List<PresentationDto> presentationDtos = new ArrayList<PresentationDto>();

		for (Presentation presentation : presentationService
				.getPresentationsForWebinar(webinarId)) {
			presentationDtos.add(presentationConverter
					.convertToDto(presentation));
		}

		return presentationDtos;
	}

	@Override
	public File getSlide(String webinarId, String presentationName,
			String currentSlide, String action) {

		int currentSlideIndex = Integer.valueOf(currentSlide.substring(5));

		if (action.equals("Next")) {
			currentSlideIndex++;
		} else {
			currentSlideIndex--;
		}

		String newSlide = "Slide" + currentSlideIndex + ".JPG";

		String filePath = MessageFormat
				.format(FacadeConstants.PRESENTATION_SLIDE_FILE_PATH,
						webinarId,
						presentationName.substring(0,
								presentationName.lastIndexOf('.')), newSlide);
		return presentationService.getSlide(filePath);
	}

	@Override
	public String getBase64Slide(String webinarId, String presentationName,
			String slide) throws Exception {

		String newSlide = "Slide" + slide + ".JPG";

		String filePath = MessageFormat
				.format(FacadeConstants.PRESENTATION_SLIDE_FILE_PATH,
						webinarId,
						presentationName.substring(0,
								presentationName.lastIndexOf('.')), newSlide);

		File imageFile = new File(filePath);
		String img = ImageEncoder.imageToBase64String(imageFile);

		return img;
	}
}
