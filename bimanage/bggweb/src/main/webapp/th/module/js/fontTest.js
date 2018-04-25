define(function (require, exports ,module) {
    var $ = require("jquery");
    require("bootstrap");


    var fontTestFunc = function (e) {
        if( $(".para-dialog").css("display")=="none" ) {
            $(".para-dialog").find("#funcCode").val("1001") ;
            var paraVOForm = $("#main_frame").contents().find("#paraVO") ;
            /*var inputEleStr = "<input type='text' name='funcCode' value='1001'></input>";*/
            paraVOForm.find("input[name='jasperUncompiledFilePath']").val("/WEB-INF/jasperResourceXML/testModel/font.xml") ;
            paraVOForm.find("input[name='jasperCompiledFilePath']").val("/WEB-INF/jasperDesignJasper/testModel/font.jasper") ;
            paraVOForm.find("input[name='funcCode']").val("1001") ;
            paraVOForm.attr("action" , "http://192.168.50.170:8080/bggweb/jasper/jasper_compile.action?compileJasper=1") ;
            $(".para-dialog").css("display", "block");
        }
    } ;


    $("#fontTest").on(
        "click" , fontTestFunc
    ) ;








}) ;