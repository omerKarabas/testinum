package com.testinium.gradmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testinium.gradmanagement.entity.School;

public interface SchoolRepository extends JpaRepository<School, Integer> {

	School findSchoolById (int schoolId);
}
