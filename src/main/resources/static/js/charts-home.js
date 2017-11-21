/*global $, document, Chart, LINECHART, data, options, window*/
$(document).ready(function () {
    'use strict';
    $.ajax({
        url: '/api/getdata',
        method: 'GET',
        success: function(data) {
           var tdata = JSON.parse(data);
            var arr= new Array();
                for(var i=0;i<tdata.length;i++){
                  arr.push(tdata[i].pcd);
                  arr.push(tdata[i].pcd);
                  arr.push(tdata[i].hpcDischarge);
                  arr.push(tdata[i].hpcSuction);
                  arr.push(tdata[i].ngp);
                  arr.push(tdata[i].ngp);
                  arr.push(tdata[i].npt);
                  arr.push(tdata[i].average)
                }
               // Main Template Color
    var brandPrimary = '#33b35a';


    // ------------------------------------------------------- //
    // Line Chart
    // ------------------------------------------------------ //
    var LINECHART = $('#lineCahrt');
    var myLineChart = new Chart(LINECHART, {
        type: 'line',
        options: {
            legend: {
                display: false
            }
        },
        data: {
            labels: ["Jan", "Feb", "Mar", "Apr", "May", "June", "July","Aug", "Sep", "Oct", "Nov","Dec"],
            datasets: [
                {
                    label: "My First dataset",
                    fill: true,
                    lineTension: 0.3,
                    backgroundColor: "rgba(77, 193, 75, 0.4)",
                    borderColor: brandPrimary,
                    borderCapStyle: 'butt',
                    borderDash: [],
                    borderDashOffset: 0.0,
                    borderJoinStyle: 'miter',
                    borderWidth: 1,
                    pointBorderColor: brandPrimary,
                    pointBackgroundColor: "#fff",
                    pointBorderWidth: 1,
                    pointHoverRadius: 5,
                    pointHoverBackgroundColor: brandPrimary,
                    pointHoverBorderColor: "rgba(220,220,220,1)",
                    pointHoverBorderWidth: 2,
                    pointRadius: 1,
                    pointHitRadius: 0,
                    data: arr,
                    spanGaps: false
                }

            ]
        }
    });
        }
    });

    // ------------------------------------------------------- //
    // Pie Chart
    // ------------------------------------------------------ //
    $.ajax({
        url: '/api/getdata',
        method: 'GET',
        success: function(data) {
            var tdata = JSON.parse(data);
            var arr = new Array();
            for (var i = 0; i < tdata.length; i++) {
                arr.push(tdata[i].pcd);
                arr.push(tdata[i].pcd);
                arr.push(tdata[i].hpcDischarge)
            }
            var PIECHART = $('#pieChart');
            var brandPrimary = '#33b35a';
            var myPieChart = new Chart(PIECHART, {
                type: 'doughnut',
                data: {
                    labels: [
                        "First",
                        "Second",
                        "Third"
                    ],
                    datasets: [
                        {
                            data: arr,
                            borderWidth: [1, 1, 1],
                            backgroundColor: [
                                brandPrimary,
                                "rgba(75,192,192,1)",
                                "#FFCE56"
                            ],
                            hoverBackgroundColor: [
                                brandPrimary,
                                "rgba(75,192,192,1)",
                                "#FFCE56"
                            ]
                        }]
                }
            });
        }
        });

    $.ajax({
        url: '/api/getdata',
        method: 'GET',
        success: function(data) {
            var level = 0;
            var tdata = JSON.parse(data);
            var arr= new Array();
            for(var i=0;i<tdata.length;i++){
                arr.push(tdata[i].npt)
            }
            for(var j=0;j<arr.length;j++){
                level=Number(arr[j])+level;
            }
            level = level/arr.length;

            // Trig to calc meter point
            var degrees = 180 - level,
                radius = .5;
            var radians = degrees * Math.PI / 180;
            var x = radius * Math.cos(radians);
            var y = radius * Math.sin(radians);

            // Path: may have to change to create a better triangle
            var mainPath = 'M -.0 -0.025 L .0 0.025 L ',
                pathX = String(x),
                space = ' ',
                pathY = String(y),
                pathEnd = ' Z';
            var path = mainPath.concat(pathX,space,pathY,pathEnd);

            var data = [{ type: 'scatter',
                x: [0], y:[0],
                marker: {size: 28, color:'850000'},
                showlegend: false,
                name: 'speed',
                text: level,
                hoverinfo: 'text+name'},
                { values: [50/6, 50/6, 50/6, 50/6, 50/6, 50/6, 50],
                    rotation: 90,
                    text: ['151-180!', '121-150', '91-121', '61-90',
                        '31-60', '0-30', ''],
                    textinfo: 'text',
                    textposition:'inside',
                    marker: {colors:['rgba(14, 127, 0, .5)', 'rgba(110, 154, 22, .5)',
                        'rgba(170, 202, 42, .5)', 'rgba(202, 209, 95, .5)',
                        'rgba(210, 206, 145, .5)', 'rgba(232, 226, 202, .5)',
                        'rgba(255, 255, 255, 0)']},
                    labels: ['151-180', '121-150', '91-120', '61-90', '31-60', '0-30', ''],
                    hoverinfo: 'label',
                    hole: .5,
                    type: 'pie',
                    showlegend: false
                }];

            var layout = {
                shapes:[{
                    type: 'path',
                    path: path,
                    fillcolor: '850000',
                    line: {
                        color: '850000'
                    }
                }],
                title: '<b>Gauge</b> <br> Speed 0-100',
                height: 1000,
                width: 1000,
                xaxis: {zeroline:false, showticklabels:false,
                    showgrid: false, range: [-1, 1]},
                yaxis: {zeroline:false, showticklabels:false,
                    showgrid: false, range: [-1, 1]}
            };

            Plotly.newPlot('myDiv', data, layout);
        }
    });
});
