package projectWork.service;

import jakarta.servlet.http.HttpSession;
import projectWork.model.Acquisto;

import java.util.List;

public interface AcquistoService {
    public List<Acquisto> getAcquisti();
    Acquisto getAcquistoById(int id);
    void inviaAcquisto(HttpSession session);
}
