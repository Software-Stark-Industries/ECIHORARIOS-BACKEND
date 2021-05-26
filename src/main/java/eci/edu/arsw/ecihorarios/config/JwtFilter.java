package eci.edu.arsw.ecihorarios.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {

    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse,
                         final FilterChain filterChain)
            throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        final String authHeader = request.getHeader("authorization");
        System.out.println("**************************************");
        System.out.println("\n request: "+request+"\n");
        System.out.println("\n request header: "+request.getHeaderNames().toString()+"\n");
        System.out.println("\n request method: "+request.getMethod()+"\n");
        System.out.println("\n request uri: "+request.getRequestURI().toString()+"\n");
        System.out.println("\n request toString: "+request.toString()+"\n");
        System.out.println("**************************************");
        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);

            filterChain.doFilter(servletRequest, response);
        } else {
            System.out.println("TOKEN JWT: "+authHeader);
            /*if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                throw new ServletException("Missing or invalid Authorization header");
            }*/

            //final String token = authHeader.substring(7);
            String token = authHeader.substring(8, authHeader.length()-1);
            //System.out.println("TOKEN SUBSTRING 7: "+token);
            try
            {
                final Claims claims = Jwts.parser().setSigningKey( "secretkey" ).parseClaimsJws( token ).getBody();
                request.setAttribute( "claims", claims );
            }
            catch ( final SignatureException e )
            {
                throw new ServletException( "Invalid token" );
            }

            filterChain.doFilter(servletRequest, response);
        }
    }
}
