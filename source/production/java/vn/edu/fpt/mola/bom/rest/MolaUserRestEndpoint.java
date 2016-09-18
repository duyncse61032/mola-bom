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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import vn.edu.fpt.mola.bom.config.annotation.RestEndpoint;
import vn.edu.fpt.mola.bom.entity.MolaRole;
import vn.edu.fpt.mola.bom.entity.MolaUser;
import vn.edu.fpt.mola.bom.entity.view.MolaUserForm;
import vn.edu.fpt.mola.bom.entity.view.MolaUserList;
import vn.edu.fpt.mola.bom.exception.ResourceNotFoundException;
import vn.edu.fpt.mola.bom.service.MolaUserService;


@RestEndpoint
public class MolaUserRestEndpoint
{
    @Inject
    MolaUserService molaUserService;

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
        if (this.molaUserService.getMolaUser(id) == null) {
            throw new ResourceNotFoundException();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Allow", "OPTIONS, HEAD, GET, PUT, DELETE");
        return new ResponseEntity<>(null, headers, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public MolaUserList read()
    {
        MolaUserList list = new MolaUserList();
        list.setList(this.molaUserService.getAllMolaUsers());
        return list;
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public MolaUser read(@PathVariable("id") int id)
    {
        MolaUser user = this.molaUserService.getMolaUser(id);
        if (user == null) {
            throw new ResourceNotFoundException();
        }
        return user;
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public ResponseEntity<MolaUser> create(@RequestBody @Valid MolaUserForm form)
    {
        MolaUser newUser = new MolaUser();
        newUser.setName(form.getName());
        newUser.setGender(form.getGender());
        newUser.setBirthday(form.getBirthday());
        newUser.setEmail(form.getEmail());
        newUser.setTelNo(form.getTelNo());
        newUser.setRole(new MolaRole[] { form.getRole() });

        MolaUser createdUser = this.molaUserService.saveMolaUser(newUser);

        String uri = ServletUriComponentsBuilder.fromCurrentServletMapping()
                .path("user/{id}")
                .buildAndExpand(createdUser.getId())
                .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);
        return new ResponseEntity<>(createdUser, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(
            @PathVariable("id") int id,
            @RequestBody @Valid MolaUserForm form)
    {
        MolaUser oldUser = this.molaUserService.getMolaUser(id);
        if (oldUser == null) {
            throw new ResourceNotFoundException();
        }
        oldUser.setName(form.getName());
        oldUser.setGender(form.getGender());
        oldUser.setBirthday(form.getBirthday());
        oldUser.setEmail(form.getEmail());
        oldUser.setTelNo(form.getTelNo());
        oldUser.setRole(new MolaRole[] { form.getRole() });
        this.molaUserService.saveMolaUser(oldUser);
    }
}
