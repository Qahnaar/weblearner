package com.bestteam.controller.utils;

public class ControllerConstants {

	public class Mappings {
		public static final String HOMEPAGE = "/";
		public static final String DASHBOARD = "/dashboard";
		public static final String LOGIN = "/login";
		public static final String REGISTER = "/register";
		public static final String WEBINAR = "/webinars/{id}";
		public static final String ATTACHMENT = "/attachment";
		public static final String UPLOAD_ATTACHMENT = "/attachment/upload";
		public static final String PRESENTATION = "/presentation";
		public static final String PRESENTATION_SLIDE = "/{webinarId}/{presentationName}/{slide}";
		public static final String UPLOAD_PRESENTATION = "/upload/{webinarId}";
		public static final String PRESENTATIONS_WEBINAR = "/webinar/{webinarId}";
	}

	public class Pages {
		public static final String HOMEPAGE = "homepage";
		public static final String DASHBOARD = "dashboard";
		public static final String LOGIN = "login";
		public static final String REGISTER = "register";
		public static final String LECTOR_WEBINAR = "lectorWebinar";
		public static final String VISITOR_WEBINAR = "visitorWebinar";

		public class Titles {
			public static final String HOMEPAGE = "Homepage";
			public static final String DASHBOARD = "Dashboard";
			public static final String LOGIN = "Login";
			public static final String REGISTER = "Register";
			public static final String WEBINAR = "Webinar";
		}
	}
	
	public class GeneralConstants {
		public static final String LOGGEDIN_USER = "LOGGEDIN_USER";
	}
}
