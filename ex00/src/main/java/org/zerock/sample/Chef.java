package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component  // bean등록
@Data
public class Chef {
	private String name;
}
