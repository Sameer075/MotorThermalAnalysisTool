
console.log(deviceInfo);

var deviceTypes = [...new Set(deviceInfo.map(x => x.deviceType))];

console.log(deviceTypes);
var tempData = {};
var allThreshold = [];
var ok = [];
var warning = [];
var alarm = [];
var data = [];
var alarmText = [];
var warningText = [];
var okText = [];

deviceTypes.forEach(deviceType => {
	var devicesOfType = deviceInfo.filter(x => x.deviceType === deviceType);
	var thresholdTemps = devicesOfType.map(x => x.threshold[x.threshold.length - 1].temp);
	tempData[deviceType] = thresholdTemps;
	allThreshold.push(...thresholdTemps);
	if (thresholdTemps >= 80) {
		console.log("Alarm");
		alarmText += deviceType + "\n";
	} else if (thresholdTemps > 60) {
		console.log("Warning");
		warningText += deviceType + "\n";
	} else {
		console.log("OK");
		okText += deviceType + "\n";
	}
	ok.push(30);
	warning.push(60);
	alarm.push(80);
});

console.log(tempData);
console.log(allThreshold);
console.log(ok);



/*var result = document.getElementById('result');
result.innerText = "Alarm Data:\n" + alarmText + "\nWarning Data:\n" + warningText + "\nOK Data:\n" + okText;*/

var alar = document.getElementById('alar');
alar.innerText = alarmText;

var warnin = document.getElementById('warnin');
warnin.innerText = warningText;

var oki = document.getElementById('oki');
oki.innerText = okText;

const canvas = document.getElementById('graph-canvas');
const ctx = canvas.getContext('2d');

var deviceName_x = deviceInfo.map(x => x[deviceTypes]);
var temp_y = deviceInfo.map(x => x[tempData]);



// Use Chart.js to create a graph
Chart.defaults.font.size = 15;
new Chart(ctx, {
	type: 'radar', // Specify the type of chart (e.g., bar, line, pie)
	data: {
		labels: deviceTypes,
		datasets: [{
			label: 'Alarm',
			data: alarm,
			fill: true,
			backgroundColor: 'rgba(255, 99, 132, 0.2)',
			borderColor: 'rgb(255, 99, 132)',
			pointBackgroundColor: 'rgb(255, 99, 132)',
			pointBorderColor: '#fff',
			pointHoverBackgroundColor: '#fff',
			pointHoverBorderColor: 'rgb(255, 99, 132)'
		}, {
			label: 'Warning',
			data: warning,
			fill: true,
			backgroundColor: 'rgba(255, 164, 27, 0.2)',
			borderColor: 'rgb(255, 164, 27)',
			pointBackgroundColor: 'rgb(255, 164, 27)',
			pointBorderColor: '#fff',
			pointHoverBackgroundColor: '#fff',
			pointHoverBorderColor: 'rgb(255, 164, 27)'
		},
		{
			label: 'Ok',
			data: ok,
			fill: true,
			backgroundColor: 'rgba(83, 145, 101,0.2)',
			borderColor: 'rgb(83, 145, 101)',
			pointBackgroundColor: 'rgb(83, 145, 101)',
			pointBorderColor: '#fff',
			pointHoverBackgroundColor: '#fff',
			pointHoverBorderColor: 'rgb(83, 145, 101)'
		},
		{
			label: 'Actual',
			data: allThreshold,
			fill: true,
			backgroundColor: 'rgba(54, 162, 235, 0.2)',
			borderColor: 'rgb(54, 162, 235)',
			pointBackgroundColor: 'rgb(54, 162, 235)',
			pointBorderColor: '#fff',
			pointHoverBackgroundColor: '#fff',
			pointHoverBorderColor: 'rgb(54, 162, 235)'
		}
		],

		 options: {
        scales: {
            pointLabels: {
                fontSize: 16 // Set the desired font size for the deviceTypes labels
            }
        }
    }
	}

});