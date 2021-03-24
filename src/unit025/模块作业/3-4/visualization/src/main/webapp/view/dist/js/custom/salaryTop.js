//1.创建echarts对象
var mychart = echarts.init(document.getElementById("main"));
//2.发送ajax请求
$.post("/industry/salaryTop.do",function(data){
    //3.在回调函数中设置 option
    mychart.setOption({
        tooltip: {    //提示组件
            trigger: 'axis',  //如果是柱状图或折线图触发
            axisPointer: {    //坐标轴指示配置项
                type: 'shadow'  // 默认值 line    shadow 阴影指示器
            }
        },
        grid: {     //直角坐标系网络 ,网络中绘制折线图  柱状图 ...
            left: '3%',   //组件举例左侧容器举例
            right: '4%',
            bottom: '3%',
            containLabel: true //grid 区域是否有坐标轴的刻度
        },
        xAxis: {
            type: 'value',  //数值轴
            boundaryGap: [0, 0.01]
        },
        yAxis: {
            type: 'category', //类目轴
            data: data.data.cities
        },
        series: [
            {
                name: '平均工资',
                type: 'bar',  //柱状图
                data: data.data.salaries,
                label: {  //图形上添加文字标签
                    show:true , //是否在标签上展示
                    position: 'insideRight' //标签数据展示位置
                }
            }
        ]
    });
},"json")