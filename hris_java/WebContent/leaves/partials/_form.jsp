<form action="">
	<div class="box-header with-border">
		<h3 class="box-title">Leave Form</h3>
		<div class="box-tools">
			<a href="index.jsp" class="btn btn-default">Back</a>
		</div>
	</div>

	<div class="box-body">
		<div class="form-group">
			<label>Employee ID</label>

			<div class="input-group">
				<div class="input-group-addon">
					<i class="fa fa-user"></i>
				</div>
				<input type="text" name="employee_id" class="form-control"
					placeholder="Employee ID">
			</div>
		</div>

		<div class="form-group">
			<label>Leave Type</label>

			<div class="input-group">
				<div class="input-group-addon">
					<i class="fa fa-list"></i>
				</div>
				<select class="form-control" name="leave_type"></select>
			</div>
		</div>

		<div class="form-group">
			<label>Reason for Leave</label>

			<div class="input-group">
				<div class="input-group-addon">
					<i class="fa fa-align-left"></i>
				</div>
				<textarea name="reason_for_leave" class="form-control" cols="30"
					rows="5" placeholder="Reason for Leave"></textarea>
			</div>
		</div>

		<div class="form-group">
			<label>Start Leave Date</label>

			<div class="input-group date">
				<div class="input-group-addon">
					<i class="fa fa-calendar"></i>
				</div>
				<input type="text" name="start_date" class="form-control pull-right">
			</div>
		</div>

		<div class="form-group">
			<label>End Leave Date</label>

			<div class="input-group date">
				<div class="input-group-addon">
					<i class="fa fa-calendar"></i>
				</div>
				<input type="text" name="end_date" class="form-control pull-right">
			</div>
		</div>
	</div>

	<div class="box-footer">
		<div class="pull-right">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</div>
</form>