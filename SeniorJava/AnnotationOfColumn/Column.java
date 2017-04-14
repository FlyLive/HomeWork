package AnnotationOfColumn;

import java.lang.annotation.*;


@Target({ElementType.FIELD})//�ࡢ�������Ա�ע
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
	public String value() default "";
	public boolean nullable() default false;
	public int maxLength() default -1;
	public int minLength() default -1;
	public int maxValue() default -1;
	public int minValue() default -1;
	
}
