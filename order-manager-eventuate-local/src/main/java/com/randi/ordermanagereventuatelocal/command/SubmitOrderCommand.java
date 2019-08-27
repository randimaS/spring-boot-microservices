package com.randi.ordermanagereventuatelocal.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SubmitOrderCommand implements OrderCommand {
    private boolean orderStatus;
}
