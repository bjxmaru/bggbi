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

       $("#paraSet").click(function(e) {

            var queryObj = {} ;

            //in main ifame page ,  query object ;
            //var mainFrameWindow =  document.getElementById("main_frame").contentWindow ;
            //var temp = $("#main_frame") ;
            //alert( $("#main_frame").contentDocument.getElementsByTagName("input")[0].value );
          // alert("asdfsd");
            //query parameter dialog  value  assigned to  iframe page para object ;

           //alert($("#main_frame").contents().find("#paraVO").html());
     /*      var theVar = $(window.frames["main_frame"].document);
           console.log(theVar.find("#paraVO"));
           var tmp = $("#main_frame").contents().find("#paraVO").find("input[name='para.paraDate']") ;*/
           //alert(tmp.html()) ;
           /* mainFrameWindow.para.paraDate = $("#paraDateTime").val() ;
            mainFrameWindow.para.paraCorpCode = $("#paraCorpCode").val() ;*/
           $("#main_frame").contents().find("input[name='para.paraDate']").val( $("#paraDateTime").val()) ;
           $("#main_frame").contents().find("input[name='para.paraCorpCode']").val( $("#paraCorpCode").val()) ;

           $("#main_frame").contents().find("#paraVO").submit() ;
           return false;

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