package com.teste.clientapp.endpoint;

import com.teste.clientapp.consume.ServiceConsumer;
import com.teste.clientapp.error.CustomErrorType;
import com.teste.clientapp.model.Client;
import com.teste.clientapp.model.Requester;
import com.teste.clientapp.repository.ClientRepository;
import com.teste.clientapp.repository.RequesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("clients")

/*classe que controla todos os endpoints*/

public class ClientEndpoint {
    @Autowired
    @Qualifier("ClientRepo")
    private final ClientRepository clientDAO;

    @Autowired
    @Qualifier("RequesterRepo")
    private final RequesterRepository requesterDAO;

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public ClientEndpoint(ClientRepository clientDAO,
                          RequesterRepository requesterDAO) {
        this.clientDAO = clientDAO;
        this.requesterDAO = requesterDAO;
    }

    @Autowired
    private HttpServletRequest request;
    // get na raiz listando todos os clients
    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(clientDAO.findAll(), HttpStatus.OK);
    }
    // get com parametro ID retornar apenas um cliente
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getClientById(@PathVariable("id") Long id) {
        boolean clientIs = clientDAO.existsById(id);

        if (clientIs) {
            Client client = clientDAO.findById(id).get();
            return new ResponseEntity<>(client, HttpStatus.OK);
        }
        return new ResponseEntity<>(new CustomErrorType("client not found"), HttpStatus.NOT_FOUND);

    }
    /* Post com dados de Nome e idade - on mesmo instante em que recupera e armazena dados
    * IP, Latitude e long, Localização, dados do tempo: temperatura min e max
    */
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Client client) {

        String ipAddress = request.getRemoteAddr();
        ServiceConsumer sc = new ServiceConsumer(ipAddress);

        client = clientDAO.save(client);

        Requester requester = new Requester();
        requester.setCreatAt(sc.getCreateAt());
        requester.setCity(sc.getCity());
        requester.setLocation(sc.getWoeid());
        requester.setTempMax(sc.getTempMax());
        requester.setTempMin(sc.getTempMin());
        requester.setUserId(client.getId());
        requesterDAO.save(requester);

        return new ResponseEntity<>(client, HttpStatus.OK);
    }
    // delete a partir do ID
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean clientIs = clientDAO.existsById(id);

        if (clientIs) {
            clientDAO.deleteById(id);
            return new ResponseEntity<>(new CustomErrorType("has been deleted"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new CustomErrorType("nothing has changed"), HttpStatus.NOT_FOUND);
    }
    // altera passando id,name e idade
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Client client) {
        clientDAO.save(client);

        return new ResponseEntity<>(client, HttpStatus.OK);
    }
}