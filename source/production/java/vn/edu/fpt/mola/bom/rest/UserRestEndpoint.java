package vn.edu.fpt.mola.bom.rest;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import vn.edu.fpt.mola.bom.config.annotation.RestEndpoint;
import vn.edu.fpt.mola.bom.entity.UserPrincipal;
import vn.edu.fpt.mola.bom.entity.view.UserForm;
import vn.edu.fpt.mola.bom.entity.view.Wrapper;
import vn.edu.fpt.mola.bom.exception.ResourceNotFoundException;
import vn.edu.fpt.mola.bom.service.UserService;


@RestEndpoint
public class UserRestEndpoint
{
    @Inject
    UserService molaUserService;

    @RequestMapping(value = "user", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> discover()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Allow", "OPTIONS, HEAD, GET, POST");
        return new ResponseEntity<>(null, headers, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> discover(@PathVariable("id") int id)
    {
        if (this.molaUserService.getUser(id) == null) {
            throw new ResourceNotFoundException();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Allow", "OPTIONS, HEAD, GET, PUT, DELETE");
        return new ResponseEntity<>(null, headers, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Wrapper<UserPrincipal> read()
    {
        return new Wrapper<UserPrincipal>(this.molaUserService.getAllUsers());
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public UserPrincipal read(@PathVariable("id") int id)
    {
        UserPrincipal user = this.molaUserService.getUser(id);
        if (user == null) {
            throw new ResourceNotFoundException();
        }
        return user;
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(
            @PathVariable("id") int id,
            @RequestBody @Valid UserForm form)
    {
        UserPrincipal oldUser = this.molaUserService.getUser(id);
        if (oldUser == null) {
            throw new ResourceNotFoundException();
        }
        form.updateEntity(oldUser);
        this.molaUserService.saveUser(oldUser);
    }
}
