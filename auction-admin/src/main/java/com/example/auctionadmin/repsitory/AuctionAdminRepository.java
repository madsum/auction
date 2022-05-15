package com.example.auctionadmin.repsitory;

import com.example.auctionadmin.model.CustomMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionAdminRepository extends JpaRepository<CustomMessage, Long> {
}
