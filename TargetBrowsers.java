import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 *  Retain the annotation defined in the class in runtime.
 */
@Retention(RetentionPolicy.RUNTIME)
/*
 *  This annotation can only be defined at class level.
 */
@Target({ElementType.TYPE})
@Inherited
public @interface TargetBrowsers { 
	//The value of annotation holds an array of browers.
	Browser[] value(); 
}
