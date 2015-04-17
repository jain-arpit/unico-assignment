class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')


        "/api/rest/push"(controller:'rest',action: [POST:'push'])
        "/api/rest/list"(controller:'rest',action: [GET:'list'])
	}
}
