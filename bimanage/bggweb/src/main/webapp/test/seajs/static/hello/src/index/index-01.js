define(function (require, exports ,module) {
    $ = require("jquery") ;

    var urlStr1 = "http://192.168.50.170:8080/bggweb/jasper/corpInfo.action" ;
    var urlStr2 = "http://www.sina.com.cn" ;

    $("#fun1").click(function () {

       //alert( $("#main_frame").contentDocument.getElementsByTagName("input")[0].value );
        alert($("#main_frame").contents().find("input[name='paraYear']").val());

        // $("#main_frmame").attr("src",urlStr1 );


    });

    $("#fun2").click(function () {

        $("#main_frmame").attr("src", urlStr2 );
    });

}) ;