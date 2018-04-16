define(function (require, exports ,module) {
    var $ = require("jquery") ;
    require("bootstrap");

    require("bootstrap-datetimepicker");
    require("bootstrap-datetimepicker-zh");

       $("#datetimepicker").datetimepicker({
           language: 'zh-CN',//显示中文
           format: 'yyyy-mm-dd',//显示格式
           minView: "month",//设置只显示到月份
           initialDate: new Date(),//初始化当前日期,
           autoclose: true,//选中自动关闭
           todayBtn: true , //显示今日按钮
           format: 'yyyy-mm-dd hh:ii:ss'
       }) ;

    var urlStr1 = "http://192.168.50.170:8080/bggweb/jasper/corpInfo.action" ;
    var urlStr2 = "http://www.sina.com.cn" ;

  /*  $("#fun1").click(function () {

       //alert( $("#main_frame").contentDocument.getElementsByTagName("input")[0].value );
        alert($("#main_frame").contents().find("input[name='paraYear']").val());

        // $("#main_frmame").attr("src",urlStr1 );


    });

    $("#fun2").click(function () {

        $("#main_frmame").attr("src", urlStr2 );
    });
*/
}) ;