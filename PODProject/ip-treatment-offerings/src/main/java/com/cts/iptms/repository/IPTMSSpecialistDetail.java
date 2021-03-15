package com.cts.iptms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.iptms.model.SpecialistDetail;

@Repository
public interface IPTMSSpecialistDetail extends JpaRepository<SpecialistDetail, Long> {

}
