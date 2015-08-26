package br.com.belaAgenda.infra.beanValidation;

import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.naming.NamingException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorFactory;

import org.hibernate.validator.cdi.HibernateValidator;

public class MyInjectingConstraintValidatorFactory implements ConstraintValidatorFactory {


    public <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> type) {
        try{

            T t = getBeanInstance(type);
            if(t==null){
                t = type.newInstance();
            }
            return t;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private BeanManager getBeanManager() throws NamingException {
            
           
            BeanManager beanManager = CDI.current().getBeanManager();
            return beanManager;
    }

    @SuppressWarnings("unchecked")
	public <T> T getBeanInstance(final Class<T> type) throws Exception{
        BeanManager beanManager =  getBeanManager();
        HibernateValidator v = type.getAnnotation(HibernateValidator.class);
        if(v!=null){
            final Set<Bean<?>> beans = beanManager.getBeans(type,v);
            beanManager.resolve(beans);
            if(!beans.isEmpty()){
                final Bean<T> bean = (Bean<T>) beanManager.resolve(beans);
                final CreationalContext<T> creationalContext = beanManager.createCreationalContext(bean);
                return (T) beanManager.getReference(bean, type,creationalContext);
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

	

	public void releaseInstance(ConstraintValidator<?, ?> instance) {
		// TODO Auto-generated method stub
		
	}



}
