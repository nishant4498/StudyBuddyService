package org.gis.studybuddy.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.gis.studybuddy.model.Subject;
import org.springframework.jdbc.core.RowMapper;

public class SubjectMapper implements RowMapper<Subject> {
	public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
		Subject subject = new Subject();
		subject.subjectId = rs.getString("subjectid");
		subject.subjectName = rs.getString("subjectName");
		subject.description = rs.getString("desc");
		return subject;
	}
}
