package org.cc.exp.security.sql.setup;

import java.sql.Date;


import org.hibernate.validator.constraints.NotEmpty;

public class TasksNBug {

	private String parent;

	@NotEmpty(message = "TYPE is required")
	private String type;

	@NotEmpty(message = "Id is required")
	private Integer id;

	@NotEmpty(message = "TYPE is required")
	private String summary;

	@NotEmpty(message = "OWNED_BY is required")
	private String owned_by;

	@NotEmpty(message = "STATUS is required")
	private String status;

	@NotEmpty(message = "STATUS is required")
	private Date modified_date;

	@NotEmpty(message = "STATUS is required")
	private String adjusted_iteration;

	@NotEmpty(message = "STATUS is required")
	private Double estimate_hours;

	@NotEmpty(message = "STATUS is required")
	private Double time_spent_hours;

	public TasksNBug(String parent, String type, Integer id, String summary, String owned_by, String status,
			Date modified_date, String adjusted_iteration, Double estimate, Double time_spent) {
		super();
		this.parent = parent;
		this.type = type;
		this.id = id;
		this.summary = summary;
		this.owned_by = owned_by;
		this.status = status;
		this.modified_date = modified_date;
		this.adjusted_iteration = adjusted_iteration;
		this.estimate_hours = estimate;
		this.time_spent_hours = time_spent;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getOwned_by() {
		return owned_by;
	}

	public void setOwned_by(String owned_by) {
		this.owned_by = owned_by;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getModified_date() {
		return modified_date;
	}

	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}

	public String getAdjusted_iteration() {
		return adjusted_iteration;
	}

	public void setAdjusted_iteration(String adjusted_iteration) {
		this.adjusted_iteration = adjusted_iteration;
	}

	public Double getEstimate() {
		return estimate_hours;
	}

	public void setEstimate(Double estimate) {
		this.estimate_hours = estimate;
	}

	public Double getTime_spent() {
		return time_spent_hours;
	}

	public void setTime_spent(Double time_spent) {
		this.time_spent_hours = time_spent;
	}

}
