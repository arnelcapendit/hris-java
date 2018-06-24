<div class="modal fade" id="add-item-modal" style="display: none;">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">x</span></button>
        <h4 class="modal-title">Add item</h4>
      </div>

      <div class="modal-body">
        <div class="form-group">
          <label>Expense Date</label>

          <div class="input-group date">
            <div class="input-group-addon">
              <i class="fa fa-calendar"></i>
            </div>
            <input type="text" name="expense_date" class="form-control pull-right">
          </div>
        </div>
        
        <div class="form-group">
          <label>Category</label>

          <div class="input-group">
            <div class="input-group-addon">
              <i class="fa fa-list"></i>
            </div>
            <input type="text" name="category" class="form-control" placeholder="Category">
          </div>
        </div>
        
        <div class="form-group">
          <label>Description</label>

          <div class="input-group">
            <div class="input-group-addon">
              <i class="fa fa-align-left"></i>
            </div>
            <textarea name="description" class="form-control" cols="30" rows="5" placeholder="Expense Description"></textarea>
          </div>
        </div>

        <div class="form-group">
          <label>Cost</label>

          <div class="input-group">
            <div class="input-group-addon">
              <i class="fa fa-money"></i>
            </div>
            <input type="text" name="cost" class="form-control" placeholder="Cost">
          </div>
        </div>
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" id="create-item-btn">Submit</button>
      </div>
    </div>
  </div>
</div>