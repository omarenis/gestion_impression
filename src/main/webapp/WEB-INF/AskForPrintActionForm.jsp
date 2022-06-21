<%@ page import="javax.jws.soap.SOAPBinding" %>
<%@ page import="com.management_teachers_impression.management_teachers_impression.models.entities.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8"/>
    <link rel="apple-touch-icon" sizes="76x76" href="./assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="./assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>list users</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
          name='viewport'/>
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"/>
    <!-- CSS Files -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/light-bootstrap-dashboard.css" rel="stylesheet" type="text/css"/>
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="assets/css/demo.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="wrapper">
    <jsp:include page="sidebar.jsp"/>
    <div class="main-panel">
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg ">
            <div class="container-fluid">
                <div class="navbar-wrapper">
                    <div class="navbar-minimize">
                        <button id="minimizeSidebar"
                                class="btn btn-warning btn-fill btn-round btn-icon d-none d-lg-block">
                            <i class="fa fa-ellipsis-v visible-on-sidebar-regular"></i>
                            <i class="fa fa-navicon visible-on-sidebar-mini"></i>
                        </button>
                    </div>
                    <a class="navbar-brand" href="#pablo"> Dashboard PRO </a>
                </div>
                <div class="collapse navbar-collapse justify-content-end">
                    <ul class="nav navbar-nav mr-auto">
                        <form class="navbar-form navbar-left navbar-search-form" role="search">
                            <div class="input-group">
                                <i class="nc-icon nc-zoom-split"></i>
                                <input type="text" value="" class="form-control" placeholder="Search...">
                            </div>
                        </form>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- End Navbar -->
        <div class="content">
            <div class="container">
                <div class="col-md-6 col-sm-12 ml-auto mr-auto">
                    <form class="form" method="post" action="<%= request.getContextPath() %>/askForPrintDocument" enctype="multipart/form-data">
                        <div class="card card-login card-hidden">
                            <div class="card-header ">
                                <h3 class="header text-center">ask to print document</h3>
                            </div>
                            <div class="card-body">
                                <div class="card-body">
                                    <c:if test="${!empty message}">
                                        <div class="alert alert-danger">${message}</div>
                                    </c:if>

                                    <div class="form-group">
                                        <label>subject</label>
                                        <div class="form-group">
                                            <select name="subjectId" class="selectpicker" data-title="Single Select" data-style="btn-default btn-outline" data-menu-style="dropdown-blue">
                                                <c:forEach var="subject" items="${subjects}">
                                                    <option value="${subject.id}">${subject.label}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>date de reception</label>
                                        <div class="form-group">
                                            <input id="datetimepicker" type="text" class="form-control datetimepicker" name="dateAskForPrint" placeholder="date ask for reception"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>number of copies</label>
                                        <input type="text" name="numberCopies" placeholder="Enter number copies" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label>Document</label>
                                        <input type="file" name="file" placeholder="the file to print" class="form-control">
                                    </div>
                                </div>
                            </div>
                            <div class="card-footer ml-auto mr-auto">
                                <button type="submit" class="btn btn-warning btn-wd">ask for print</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="assets/js/core/bootstrap.min.js" type="text/javascript"></script>
<!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
<script src="assets/js/plugins/bootstrap-switch.js"></script>
<!--  Google Maps Plugin    -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?YOUR_KEY_HERE"></script>
<!--  Chartist Plugin  -->
<script src="assets/js/plugins/chartist.min.js"></script>
<!--  Notifications Plugin    -->
<script src="assets/js/plugins/bootstrap-notify.js"></script>
<!--  jVector Map  -->
<script src="assets/js/plugins/jquery-jvectormap.js" type="text/javascript"></script>
<!--  Plugin for Date Time Picker and Full Calendar Plugin-->
<script src="assets/js/plugins/moment.min.js"></script>
<!--  DatetimePicker   -->
<script src="assets/js/plugins/bootstrap-datetimepicker.js"></script>
<!--  Sweet Alert  -->
<script src="assets/js/plugins/sweetalert2.min.js" type="text/javascript"></script>
<!--  Tags Input  -->
<script src="assets/js/plugins/bootstrap-tagsinput.js" type="text/javascript"></script>
<!--  Sliders  -->
<script src="assets/js/plugins/nouislider.js" type="text/javascript"></script>
<!--  Bootstrap Select  -->
<script src="assets/js/plugins/bootstrap-selectpicker.js" type="text/javascript"></script>
<!--  jQueryValidate  -->
<script src="assets/js/plugins/jquery.validate.min.js" type="text/javascript"></script>
<!--  Plugin for the Wizard, full documentation here: https://github.com/VinceG/twitter-bootstrap-wizard -->
<script src="assets/js/plugins/jquery.bootstrap-wizard.js"></script>
<!--  Bootstrap Table Plugin -->
<script src="assets/js/plugins/bootstrap-table.js"></script>
<!--  DataTable Plugin -->
<script src="assets/js/plugins/jquery.dataTables.min.js"></script>
<!--  Full Calendar   -->
<script src="assets/js/plugins/fullcalendar.min.js"></script>
<!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
<script src="assets/js/light-bootstrap-dashboard.js?v=2.0.1" type="text/javascript"></script>
<!-- Light Dashboard DEMO methods, don't include it in your project! -->
<script src="assets/js/demo.js"></script>
<script>
    $(document).ready(function () {
        demo.checkFullPageBackgroundImage();

        setTimeout(function () {
            // after 1000 ms we add the class animated to the login/register card
            $('.card').removeClass('card-hidden');
        }, 700)
    });
</script>
</body>
</html>
