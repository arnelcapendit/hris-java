<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Advanced System Design and Implementation</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    
    <%@ include file="/partials/_stylesheets.jsp" %>

    <link rel="stylesheet" href="/ASDI/assets/ASDI/css/shifts_and_schedules.css">
    <link rel="stylesheet" href="/ASDI/assets/ASDI/css/shifts_and_schedules/index.css">
  </head>

  <body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">
      <%@ include file="/partials/_top_nav.jsp" %>

      <%@ include file="/partials/_side_nav.jsp" %>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            <i class="fa fa-dashboard"></i> Shifts and Schedules Management
          </h1>

          <!-- <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Dashboard</li>
          </ol> -->
        </section>

        <section class="content">
          <div class="row">
            <div class="col-xs-12">
              <div class="box">
                <div class="box-header">
                  <h3 class="box-title">Shifts and Schedules List</h3>
                  <div class="box-tools">
                    <a href="new/shift.jsp" class="btn btn-primary">New Shift</a>
                    <a href="new/schedule.jsp" class="btn btn-info">New Schedule</a>
                  </div>
                </div>

                <div class="box-body table-responsive">
                  <table class="table table-hover">
                    <thead>
                      
                    </thead>

                    <tbody>
                      
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </section>
      </div>
      
      <%@ include file="/partials/_footer.jsp" %>
    </div><!-- ./wrapper -->

    <%@ include file="/partials/_scripts.jsp" %>

    <script src="/ASDI/assets/ASDI/js/shifts_and_schedules.js"></script>
    <script src="/ASDI/assets/ASDI/js/shifts_and_schedules/index.js"></script>
  </body>
</html>