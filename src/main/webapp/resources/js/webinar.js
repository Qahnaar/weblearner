var presentationName = '';
var webinarId = '';

bindAll = function() {
	$(".presentation").on("click", "a", function(event) {
		event.preventDefault;
		var target = $(event.target).attr("id");
		bindPresentationSwapTrigger(target);
	})

	webinarId = $("#webinar_id").text();
	
	bindPresentationUpload();
	bindPresentationSelect();
	getPresentations();
	bindPresentationButtons();
};

bindPresentationSwapTrigger = function(target) {
	var imagesId = $("#images").attr("id"), googleDocsId = $("#googleDocs")
			.attr("id");

	if (target === imagesId) {
		triggerShow(imagesId);
		triggerHide(googleDocsId);
	} else {
		triggerShow(googleDocsId);
		triggerHide(imagesId);
	}
};

bindPresentationUpload = function() {
	$("#uploadPresentation").submit(function(event) {
		$.ajax({
			url : $("#uploadPresentation").attr("action"),
			data : new FormData(document.getElementById("uploadPresentation")),
			enctype : 'multipart/form-data',
			processData : false,
			type : "POST",
			contentType : false,

			success : function(result) {
				if (result !== "") {
					createPresentationEntry(result.name);
					triggerHide($("#images").attr("id"));
				} else {
					alert("This presentation exists. Try another name.");
				}
			},

			error : function() {
				alert("Damn an error while uploading.");
			}
		});

		event.preventDefault();
	});
};

bindPresentationSelect = function() {
	$("#presentationTable").on(
			'click',
			'a.selector',
			function(e) {
				$("#presentationContent").css({
					'display' : 'none'
				});

				$(".slides").css({
					'display' : 'block'
				});

				presentationName = $(e.currentTarget).parent().prev().text();

				sendPresentationMessage(presentationName, $("#currentSlide")
						.text(), webinarId);

			});
};

loadAndDisplaySlide = function(webinarId, presentationName, slide) {
	$.ajax({
		url : "/weblearner/presentation/" + webinarId + "/" + presentationName
				+ "/" + slide,
		type : "GET",

		success : function(result) {
			var img = "<img src='data:image/jpg;base64," + result + "'/>";
			$("#slideContainer").html(img);
		},

		error : function() {
			alert("Damn an error while loading slide.");
		}
	});
};

bindPresentationButtons = function() {
	$(".slides").on(
			"click",
			"#nextSlide",
			function(e) {
				var curSlide = $("#currentSlide"),
					curSlideText = curSlide.text();
				curSlide.text(parseInt(curSlideText) + 1);
				sendPresentationMessage(presentationName, curSlide.text(), webinarId);
			});

	$(".slides").on(
			"click",
			"#prevSlide",
			function(e) {
				var curSlide = $("#currentSlide"),
					curSlideText = curSlide.text();
				curSlide.text(parseInt(curSlideText) - 1);
				sendPresentationMessage(presentationName, curSlide.text(), webinarId);
			});
};

createPresentationEntry = function(presentation) {
	var openingDiv = '<div class="presentation_entry"><div class="presentation_name">';
	var closingDiv = '</div><div class="presentation_selector"><a class="btn btn-default btn-success btn-sm active selector">Select</a></div></div>';

	var div = openingDiv + presentation + closingDiv;
	$(".presentation_table").append(div);
}

getPresentations = function() {
	$.ajax({
		url : '/weblearner/presentation/webinar/' + webinarId,
		processData : false,
		type : "GET",
		contentType : false,

		success : function(result) {
			var length = result.presentationNames.length;
			for (var i = 0; i < length; i++) {
				createPresentationEntry(result.presentationNames[i]);
			}
			result.presentationNames
			console.log(result);
		},

		error : function(result) {
			alert("DAMNNNNN. Couldn't load presentations. Reload page.");
		}
	});
};

triggerShow = function(id) {
	$("." + id + "_container").css({
		display : 'block'
	});
};

triggerHide = function(id) {
	$("." + id + "_container").css({
		display : 'none'
	});
};

$(document).ready(function() {
	bindAll();
});
