package org.resteasy.plugins.server.resourcefactory;

import org.resteasy.spi.HttpInput;
import org.resteasy.spi.HttpOutput;
import org.resteasy.spi.ResourceFactory;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public class POJOResourceFactory implements ResourceFactory
{
   private Class<?> scannableClass;

   public POJOResourceFactory(Class<?> scannableClass)
   {
      this.scannableClass = scannableClass;
   }

   public Object createResource(HttpInput input, HttpOutput output)
   {
      try
      {
         return scannableClass.newInstance();
      }
      catch (InstantiationException e)
      {
         throw new RuntimeException(e.getCause());
      }
      catch (IllegalAccessException e)
      {
         throw new RuntimeException(e);
      }
   }

   public Class<?> getScannableClass()
   {
      return scannableClass;
   }
}
