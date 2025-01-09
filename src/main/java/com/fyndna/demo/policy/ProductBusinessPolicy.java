package com.fyndna.demo.policy;

import com.fyndna.common.type.MessageObject;
import com.fyndna.demo.entity.Product;
import com.fyndna.infra.policy.AbstractBusinessPolicy;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author sharangborde
 */
@Component
public class ProductBusinessPolicy extends AbstractBusinessPolicy<Product> {
  @Override
  protected void validatePolicy(Product product, String method, List<MessageObject> errorMessage) {}
}
