package com.tindung.service;

import com.tindung.service.*;
import com.tindung.repository.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.tindung.model.*;

public interface OrdersService {
    public Order create(JsonNode orderData);

    public Order findById(Integer orderId);

    // public List<Order> findByUsername(String username);
}
