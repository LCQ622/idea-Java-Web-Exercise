$(function () {
    var names=new Array();
    var salarys=new Array();
    var  obj=null;
    //通过ajax 请求 emp   得到 json 数据
    $.get("emp",function (data) {
        for (var i = 0; i < data.length; i++) {
            names[i]=data[i].name;
            salarys[i]=data[i].salary;
        }


        obj={
            chart: {
                //设置为 柱状图
                type: "column"
            },
            title:{
                //设置标题
                text:"员工工资统计"
            },
            subtitle:{
                //设置副标题
                text:"数据来源：bill 数据库"
            },
            xAxis:{
                //设置x 轴
                categories:names
            },
            yAxis:{
                //设置y 轴
                min:0, //设置y 轴的最小值为0
                title: {
                    //设置y 轴的 标题
                    text:"工资"
                }
            },
            //设置数据
            series:[{
                name:"工资",
                data:salarys
            }],
            credits:{
                //禁用 版权logo
                enabled: false
            }
        }


        //执行 highcharts
        $("#com").highcharts(obj);
    });



});