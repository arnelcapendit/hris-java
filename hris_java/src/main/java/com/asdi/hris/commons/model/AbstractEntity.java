package com.asdi.hris.commons.model;

import com.asdi.hris.commons.exception.InvalidIDException;

public class AbstractEntity {

	private int id;

	private final int userId;

	public AbstractEntity(int id, int userId) throws InvalidIDException {
		super();

		if (id < 0)
			throw new InvalidIDException("Invalid id : " + id);

		if (userId < 0)
			throw new InvalidIDException("Invalid user id : " + userId);

		this.id = id;

		this.userId = userId;
	}

	public AbstractEntity(String id, String userId) throws InvalidIDException {
		super();

		if (null == userId)
			userId = "0";
		if (null == id)
			id = "0";
		try {
			if (Integer.parseInt(userId) < 0)
				throw new InvalidIDException("Invalid user id : " + userId);

			if (Integer.parseInt(id) < 0)
				throw new InvalidIDException("Invalid leave id : " + id);

			this.id = Integer.parseInt(id);

			this.userId = Integer.parseInt(userId);
		} catch (Exception e) {
			throw new InvalidIDException("Invalid userId : " + userId);
		}
	}

	public AbstractEntity(String userId) throws InvalidIDException {
		super();
		if (null == userId)
			userId = "0";
		try {
			if (Integer.parseInt(userId) < 0)
				throw new InvalidIDException("Invalid userId : " + userId);

			this.userId = Integer.parseInt(userId);
		} catch (Exception e) {
			throw new InvalidIDException("Invalid userId : " + userId);
		}

	}

	public AbstractEntity(int userId) throws InvalidIDException {
		super();
		if (userId < 0)
			throw new InvalidIDException("Invalid userId : " + userId);

		this.userId = userId;

	}

	public int getId() {
		return id;
	}

	public int getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AbstractEntity [id=");
		builder.append(id);
		builder.append(", userId=");
		builder.append(userId);
		builder.append("]");
		return builder.toString();
	}
}
