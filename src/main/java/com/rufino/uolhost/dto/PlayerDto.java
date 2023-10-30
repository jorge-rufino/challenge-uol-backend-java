package com.rufino.uolhost.dto;

import com.rufino.uolhost.model.GroupType;

public record PlayerDto(String name, String email, String phone, GroupType groupType) {

}
