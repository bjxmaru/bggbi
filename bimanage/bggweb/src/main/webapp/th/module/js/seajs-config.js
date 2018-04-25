// Set configuration
seajs.config({
    base: "../module/",
    alias: {
        "jquery": "jquery/jquery-3.3.1.js" ,
        "bootstrap": "bootstrap/bootstrap.dist/js/bootstrap.js",
        "bootstrap-datetimepicker": "bootstrap/bootstrap.datetimepicker/js/bootstrap-datetimepicker.js" ,
        "bootstrap-datetimepicker-zh": "bootstrap/bootstrap.datetimepicker/js/bootstrap-datetimepicker-zh-CN.js"
    }
});

seajs.use("js/index-01") ;
seajs.use("js/fontTest") ;