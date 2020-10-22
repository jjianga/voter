const httpServer = {};

httpServer.post = (url, data, succeed, fail)=>{
    $.ajax({
        type: "POST",
        url: url,
        data: data,
        dataType: "json",
        cache: false,
        headers: {
            "content-type": "application/x-www-form-urlencoded"
        },
        contentType: 'application/x-www-form-urlencoded',
        success: (data) => {
            if(isTest)console.log(data);
            if ("function" == typeof(succeed)) succeed(data);
        },
        error: (data) => {
            console.error(data);
            if ("function" == typeof(fail)) fail(data);
        }
    });
}

httpServer.postJson = (url, data, succeed, fail)=>{
    $.ajax({
        type: "POST",
        url: url,
        contentType: "application/json; charset=utf-8",
        data: data,
        dataType: "json",
        success: (data) => {
            console.log(data);
            if ("function" == typeof(succeed)) succeed(data);
        },
        error: (data) => {
            console.log(data);
            if ("function" == typeof(fail)) fail(data);
        }
    });
}