define(function (require, exports ,module) {
    $ = require("jquery") ;

    $("#fun1").click(function () {

        $("#main_frmame").attr("src", "http://www.baidu.com" );
    });

    $("#fun2").click(function () {

        $("#main_frmame").attr("src", "http://www.sina.com.cn" );
    });

}) ;