bindAll = function() {
	var featuredInnerContainer = $(".featured-inner-container");
	var featuredElementWidth = featuredInnerContainer.children("div:eq(0)")
			.outerWidth(true);

	this.bindFeaturedAnimation(featuredInnerContainer, featuredElementWidth);
};

bindFeaturedAnimation = function(featuredInnerContainer, featuredElementWidth) {

	var featuredElements = 3, featuredInnerContainerChildren = featuredInnerContainer
			.children(), panelWidth = featuredElementWidth * featuredElements, childrenLength = featuredInnerContainerChildren.length, runningIndex = 0;

	if (childrenLength < featuredElements) {
		var remarginValue = parseInt(featuredInnerContainerChildren.first()
				.css('marginLeft').replace("px", ""))
				+ featuredElementWidth / childrenLength;
		featuredInnerContainerChildren.first().css({
			'marginLeft' : remarginValue
		});
	}

	$("#control-panel, .featured-outer-container").css({
		'width' : panelWidth
	});

	$("#prev").click(function(event) {
		event.preventDefault();
		if (runningIndex > 0) {
			featuredInnerContainer.animate({
				'marginLeft' : '+=' + featuredElementWidth
			});
			runningIndex--;
			redrawControls();
		}
	});

	$("#next").click(function(event) {
		event.preventDefault();
		if (runningIndex < (childrenLength - featuredElements)) {
			featuredInnerContainer.animate({
				'marginLeft' : '-=' + featuredElementWidth
			});
			runningIndex++;
			redrawControls();
		}
	});

	redrawControls = function() {
		var prevControl = $("#prev"), nextControl = $("#next");

		if (runningIndex <= 0) {
			prevControl.fadeOut(250);
		} else if (runningIndex >= (childrenLength - featuredElements)) {
			nextControl.fadeOut(250);
		} else {
			prevControl.fadeIn();
			nextControl.fadeIn();
		}
	};
};

$(document).ready(function() {
	bindAll();
});
