package AnnotationOfLabel;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface Label {
	public String value();
}
