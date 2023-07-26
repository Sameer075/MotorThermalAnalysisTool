 const ctx = document.getElementById('myChart');

  new Chart(ctx, {
    type: 'radar',
    data: {
      labels: ['M1TB', 'M2TR', 'M1TR', 'M1TY', 'M2TB', 'M3TB'],
      datasets: [{
    	  	label: 'Alarm',
  	    	data: [80, 80, 80, 80, 80, 80],
  
    	    borderColor: 'rgb(255, 99, 132)',
    	    pointBorderColor: '#fff',
    	    pointHoverBackgroundColor: '#fff',
    	    pointHoverBorderColor: 'rgb(255, 99, 132)'
    	  }, {
    	    label: 'Warning',
    	    data: [50, 50, 50, 50, 50, 50],

    	
    	    borderColor: 'rgb(242, 190, 34)',
    	    pointBorderColor: '#fff',
    	    pointHoverBackgroundColor: '#fff',
    	    pointHoverBorderColor: 'rgb(54, 162, 235)'
    	  },
    	  {label: 'OK',
  	    data: [30, 30, 30, 30, 30, 30],
  	    fill: true,
  	
  	    borderColor: 'rgb(0, 255, 0)',
  	    pointBorderColor: '#fff',
  	    pointHoverBackgroundColor: '#fff',
  	    pointHoverBorderColor: 'rgb(54, 162, 235)'
  	  }],
    },
   /*  options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    } */
  });