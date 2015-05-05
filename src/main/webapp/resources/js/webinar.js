bindAll = function() {
	$(".presentation").on("click", "a", function(event) {
		event.preventDefault;
		var target = $(event.target).attr("id");
		bindPresentationSwapTrigger(target);
	})

	bindPresentationUpload();
	bindPresentationSelect();
	getPresentations();
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

				sendPresentationMessage($(e.currentTarget).parent().prev()
						.text(), $("#currentSlide").text(), $("#nextSlide").text(), $(
						"#webinar_id").text());

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
		url : '/weblearner/presentation/webinar/' + $("#webinar_id").text(),
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
