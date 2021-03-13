<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Dashboard - SB Admin</title>
    <link href="css/styles.css" rel="stylesheet" />
    <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="./style/spinner.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>COVIDAR</title>
</head>


<body onunload="chart()" class="sb-nav-fixed">
<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <h2 style="color: #EEEEEE">InfoVis ITBA</h2>
</nav>


<div id="layoutSidenav">
    <div id="layoutSidenav_nav">
        <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">

        </nav>
    </div>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid">
                <h1 class="mt-4">COVID-API</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item active">Monitoreo general de pandemia</li>
                </ol>
                <div class="row">
                    <div class="col-xl-3 col-md-6">
                        <div class="card bg-primary text-white mb-4">
                            <div class="card-body">
                                <h5 class="card-title">Dias de Pandemia</h5>
                                <h6 class="card-subtitle mb-2 text-muted" id="length">
                                    <div class="spinner-border" role="status">
                                        <span class="sr-only">Loading...</span>
                                    </div>
                                </h6>
                                <p class="card-text">Total de dias desde primer caso registrado de COVID en Argentina</p>
                            </div>
                            <div class="card-footer d-flex align-items-center justify-content-between">
                                <a class="small text-white stretched-link" href="#">View Details</a>
                                <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-md-6">
                        <div class="card bg-warning text-white mb-4">
                            <div class="card-body">
                                <h5 class="card-title">Casos COVID positivo</h5>
                                <h6 class="card-subtitle mb-2 text-muted" id="cases">
                                    <div class="spinner-border" role="status">
                                        <span class="sr-only">Loading...</span>
                                    </div>
                                </h6>
                                <p class="card-text">Total de casos de covid positivo en Argentina</p>
                            </div>
                            <div class="card-footer d-flex align-items-center justify-content-between">
                                <a class="small text-white stretched-link" href="#">View Details</a>
                                <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-md-6">
                        <div class="card bg-success text-white mb-4">
                            <div class="card-body"><h5 class="card-title">Recuperados</h5>
                                <h6 class="card-subtitle mb-2 text-muted" id="cases-deaths">
                                    <div class="spinner-border" role="status">
                                        <span class="sr-only">Loading...</span>
                                    </div>
                                </h6>
                                <p class="card-text">
                                    Se estima que el numero de recuperados es la diferecia entre la cantidad de casos y la cantidad de falleciminetos
                                </p></div>
                            <div class="card-footer d-flex align-items-center justify-content-between">
                                <a class="small text-white stretched-link" href="#">View Details</a>
                                <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-md-6">
                        <div class="card bg-danger text-white mb-4">
                            <div class="card-body">
                                <h5 class="card-title">Muertes por COVID</h5>
                                <h6 class="card-subtitle mb-2 text-muted" id="deaths">
                                    <div class="spinner-border" role="status">
                                        <span class="sr-only">Loading...</span>
                                    </div>
                                </h6>
                                <p class="card-text">Total de muertes por covid en Argentina</p></div>
                            <div class="card-footer d-flex align-items-center justify-content-between">
                                <a class="small text-white stretched-link" href="#">View Details</a>
                                <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                            </div>
                        </div>
                    </div>
                </div>

                        <div class="card">
                            <div class="card-header">
                                <i class="fas fa-chart-area mr-1"></i>
                                Analisis Curva de curva de fallecimientos
                            </div>
                            <div class="card-body"><canvas id="myChart2" width="100%" height="40"></canvas></div>
                        </div>



                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-chart-bar mr-1"></i>
                                Analisis casos por provincias
                            </div>
                            <div class="card-body"><canvas id="myChart" width="100%" height="40"></canvas></div>
                        </div>
            </div>
        </main>
        <footer class="py-4 bg-light mt-auto">
            <div class="container-fluid">
                <div class="d-flex align-items-center justify-content-between small">
                    <div class="text-muted">Copyright &copy; COVID-ITBA</div>
                    <div>
                        <a href="https://www.itba.edu.ar/">Privacy Policy</a>
                    </div>
                </div>
            </div>
        </footer>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="js/scripts.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="assets/demo/chart-area-demo.js"></script>
<script src="assets/demo/chart-bar-demo.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
<script src="assets/demo/datatables-demo.js"></script>
<div id="spinner">

</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js" integrity="sha512-d9xgZrVZpmmQlfonhQUvTR7lMPtO7NkZMkA0ABN3PHCbKA5nqylQ/yWlFAyY6hYgdF1Qh6nYiuADWwKB4C2WSw==" crossorigin="anonymous"></script>

<script>
    window.onload = function loadData() {
        const spinner = document.getElementById("spinner");
        const cases_url = window.location.href + "api/main/cases";
        const deaths_url = window.location.href + "api/main/deaths";
        const states_url = window.location.href + "api/main/provinces";
        const cases_states_url = window.location.href + "api/main/casesProv";
        const deaths_by_date_url = window.location.href + "api/main/deathsByDay/320";
        const pandemic_lenght_url = window.location.href + "api/main/pandemicLength";

        let states = [];
        let cases = [];
        let day= [];
        let deathsByDay = []
        let cases_deaths = 0;
        let casesNum = 0;


        fetch(pandemic_lenght_url)
            .then(response => response.json())
            .then(data => {
                document.getElementById("length").innerHTML = data.number
            })

        fetch(deaths_by_date_url).then( response => response.json()).then(data =>{
            data.forEach( d =>{
                day.push(d.fecha_fallecimiento);
                deathsByDay.push(d.aux);

                var config = {
                    type: 'line',
                    data: {
                        labels: day,
                        datasets: [{
                            label: 'Filled',
                            // backgroundColor: window.chartColors.red,
                            // borderColor: window.chartColors.red,
                            data: deathsByDay,
                            fill: true,
                        }]
                    },
                    options: {
                        responsive: true,
                        title: {
                            display: true,
                            text: 'Fallecidos por dia'
                        },
                        tooltips: {
                            mode: 'index',
                            intersect: false,
                        },
                        hover: {
                            mode: 'nearest',
                            intersect: true
                        },
                        scales: {
                            xAxes: [{
                                display: true,
                                scaleLabel: {
                                    display: true,
                                    labelString: 'Dia'
                                }
                            }],
                            yAxes: [{
                                display: true,
                                scaleLabel: {
                                    display: true,
                                    labelString: 'Fallecimientos'
                                }
                            }]
                        }
                    }
                };


                var ctx = document.getElementById('myChart2').getContext('2d');
                var myChart2 = new Chart(ctx, config);

            })
        })

        fetch(cases_url)
            .then(response => response.json())
            .then(data => {
                casesNum = data.number;
                document.getElementById("cases").innerHTML = data.number;
                fetch(deaths_url)
                    .then(response => response.json())
                    .then(data => {
                        cases_deaths = casesNum - data.number;
                        document.getElementById("cases-deaths").innerHTML = cases_deaths;
                        document.getElementById("deaths").innerHTML = data.number});
            });
        fetch(cases_states_url)
            .then(response => response.json())
            .then(data => {
                data.sort((a, b) => (a.aux > b.aux) ? -1 : 1);
                data.forEach(d => {
                    cases.push(d.aux);
                    states.push(d.carga_provincia_nombre)
                });
                console.log("casosss", data);
                spinner.setAttribute('hidden', '');


                var ctx = document.getElementById('myChart').getContext('2d');

                var myChart = new Chart(ctx, {
                    type: 'horizontalBar',
                    data: {
                        labels: states,
                        datasets: [{
                            label: '# casos',
                            data: cases,
                            backgroundColor: [
                                'rgba(255, 0, 0, 0.2)',
                                'rgba(255, 90, 0, 0.2)',
                                'rgba(255, 156, 0, 0.2)',
                                'rgba(255, 198, 0, 0.2)',
                                'rgba(255, 255, 0, 0.2)',
                                'rgba(222, 255, 0, 0.2)'
                            ],
                            borderColor: [
                                'rgba(255, 99, 132, 1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                                'rgba(153, 102, 255, 1)',
                                'rgba(255, 159, 64, 1)'
                            ],
                            borderWidth: 1
                        }]
                    },
                    options: {
                        scales: {
                            yAxes: [{
                                ticks: {
                                    beginAtZero: true
                                }
                            }]
                        }
                    }
                });
            });
    }

</script>

</body>
</html>

