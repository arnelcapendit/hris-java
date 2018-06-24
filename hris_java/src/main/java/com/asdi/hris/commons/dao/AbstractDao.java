package com.asdi.hris.commons.dao;

import java.util.Collection;

import com.asdi.hris.claims.reimbursement.exception.ClaimsAndReimbursementException;
import com.asdi.hris.commons.exception.HRISException;
import com.asdi.hris.leave.exception.LeaveApplicationSQLException;

public interface AbstractDao<C> {

	public C find(C obj) throws HRISException;

	public Collection<C> list(C obj) throws HRISException;

	public void update(C obj) throws HRISException;

	public int insert(C obj) throws HRISException;

	public void delete(C obj) throws HRISException;
}
