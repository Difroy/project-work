package projectWork.Service;

import jakarta.servlet.http.HttpSession;
import projectWork.Model.Acquisto;

import java.util.List;

public interface AcquistoService {
    public List<Acquisto> getAcquisti();
    Acquisto getAcquistoById(int id);
    void inviaAcquisto(HttpSession session);
}
