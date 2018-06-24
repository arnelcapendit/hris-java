<form action="">
  <div class="box-header with-border">
    <h3 class="box-title">Application Form</h3>
    <div class="box-tools">
      <a href="/ASDI/claims_and_reimbursements" class="btn btn-default">Back</a>
    </div>
  </div>

  <div class="box-body">
    <div class="form-group">
      <label>Employee ID</label>

      <div class="input-group">
        <div class="input-group-addon">
          <i class="fa fa-user"></i>
        </div>
        <input type="text" name="employee_id" class="form-control" placeholder="Employee ID">
      </div>
    </div>

    <div class="form-group">
      <label>Application Type</label>

      <div class="input-group">
        <div class="input-group-addon">
          <i class="fa fa-list"></i>
        </div>
        <select class="form-control" name="application_type"></select>
      </div>
    </div>

    <div class="form-group">
      <label>Type</label>

      <div class="input-group date">
        <div class="input-group-addon">
          <i class="fa fa-list"></i>
        </div>
        <select class="form-control" name="type"></select>
      </div>
    </div>
    
    <div class="form-group">
      <label>Purpose of Expense</label>

      <div class="input-group">
        <div class="input-group-addon">
          <i class="fa fa-align-left"></i>
        </div>
        <textarea name="purpose_of_expense" class="form-control" cols="30" rows="5" placeholder="Purpose of Expense"></textarea>
      </div>
    </div>

    <div class="form-group">
      <label>Period Start</label>

      <div class="input-group date">
        <div class="input-group-addon">
          <i class="fa fa-calendar"></i>
        </div>
        <input type="text" name="period_start" class="form-control pull-right">
      </div>
    </div>

    <div class="form-group">
      <label>Period End</label>

      <div class="input-group date">
        <div class="input-group-addon">
          <i class="fa fa-calendar"></i>
        </div>                        
        <input type="text" name="period_end" class="form-control pull-right">
      </div>
    </div>

    <div class="form-group">
      <label>
        Itemized Expenses
        &nbsp;
        <a href="#" id="add-item-btn" class="btn btn-success btn-xs" data-toggle="tooltip" title="Add Item"><i class="fa fa-plus"></i></a>
      </label>

      <div class="table-responsive">
        <table class="table table-hover">
          <thead>
            <tr>
              <th>Date</th>
              <th>Description</th>
              <th>Category</th>
              <th>Cost</th>
              <th></th>
            </tr>
          </thead>

          <tbody></tbody>
        </table>
      </div>
    </div>
  </div>

  <div class="box-footer">
    <div class="pull-right">
      <button type="submit" class="btn btn-primary">Submit</button>
    </div>
  </div>
</form>