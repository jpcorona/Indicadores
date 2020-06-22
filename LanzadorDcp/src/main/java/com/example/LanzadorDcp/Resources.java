package com.example.LanzadorDcp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Resources {

	/** The props. */
    private static Environment props = null;

    /**
     * Sets the props.
     *
     * @param props the new props
     */
    @Autowired
    public void setProps(Environment props) {
        Resources.props = props;
    }

    /**
     * Instantiates a new resources.
     */
    private Resources(){

    }

    /**
     *
     * @param p_resourcekey the p resourcekey
     * @return the resource
     */
    public static String getResource(String p_resourcekey){
        return props.getProperty(p_resourcekey);
    }
	
	


}
