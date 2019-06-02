$(function () {
    var names=new Array();
    var salarys=new Array();
    var  obj=null;
    $.get("emp",function (data) {
        for (var i = 0; i < data.length; i++) {
            names[i]=data[i].name;
            salarys[i]=data[i].salary;
        }
        console.log(names);
        console.log(salarys);

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
                categories:names
            },
            yAxis:{
                min:0,
                title: {
                    text:"工资"
                }
            },
            series:[{
                name:"工资",
                data:salarys
            }],
            credits:{
                enabled: false
            }
        }


        $("#com").highcharts(obj);
    });



});