define(function (require, exports , module) {
    require("ztree");
    var zTreeObj;
    // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
    var setting = {};
    // zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
    var zNodes = [
        {name:"测试1", open:true, children:[
                {name:"编译"}, {name:"计算"}]},
        {name:"测试2", open:true, children:[
                {name:"打印"}, {name:"导出"}]}
    ];
     zTreeObj = $.fn.zTree.init($("#fun-tree"), setting, zNodes);

})