<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Advanced System Design and Implementation</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    
    <%@ include file="../partials/_stylesheets.jsp" %>
    
    <link rel="stylesheet" href="/asdi/assets/ASDI/css/leaves.css">
    <link rel="stylesheet" href="/asdi/assets/ASDI/css/leaves/index.css">
  </head>

  <body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">
      <%@ include file="../partials/_top_nav.jsp" %>

      <%@ include file="../partials/_side_nav.jsp" %>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            <i class="fa fa-list"></i> Leaves Management
          </h1>
        </section>

        <section class="content">
          <div class="row">
            <div class="col-xs-12">
              <div class="box">
                <div class="box-header">
                  <h3 class="box-title">Leaves List</h3>
                  <div class="box-tools">
                    <a href="/asdi/leaves/new.jsp" class="btn btn-primary">File Leave</a>
                  </div>
                </div>

                <div class="box-body table-responsive">
                  <%@ include file="partials/_list.jsp" %>                  

                  <%@ include file="partials/_reason_form_modal.jsp" %>
                  <%@ include file="partials/_reason_modal.jsp" %>
                </div>
              </div>
            </div>
          </div>
        </section>
      </div>
      
      <%@ include file="../partials/_footer.jsp" %>
    </div><!-- ./wrapper -->

    <%@ include file="../partials/_scripts.jsp" %>

    <script src="/asdi/assets/ASDI/js/leaves.js"></script>
    <script src="/asdi/assets/ASDI/js/leaves/index.js"></script>
  </body>
</html>