package org.statesync.spring.demo.security;

import java.security.Principal;

import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.statesync.spring.demo.entity.UserProfile;

public class AuthenticatedUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public Object resolveArgument(final MethodParameter methodParameter, final ModelAndViewContainer mavContainer,
			final NativeWebRequest webRequest, final WebDataBinderFactory binderFactory) throws Exception {
		if (this.supportsParameter(methodParameter)) {
			final Principal principal = webRequest.getUserPrincipal();
			return principal == null ? WebArgumentResolver.UNRESOLVED
					: ((UserBean) ((Authentication) principal).getPrincipal()).getProfile();
		} else {
			return WebArgumentResolver.UNRESOLVED;
		}
	}

	@Override
	public boolean supportsParameter(final MethodParameter methodParameter) {
		return methodParameter.getParameterAnnotation(AuthenticatedUser.class) != null
				&& methodParameter.getParameterType().equals(UserProfile.class);
	}
}
