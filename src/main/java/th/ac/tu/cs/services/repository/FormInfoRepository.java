package th.ac.tu.cs.services.repository;

import th.ac.tu.cs.services.model.FormInfo;

public interface FormInfoRepository {

    int saveInfo(FormInfo formInfo);

    int saveSubject(FormInfo formInfo);

}
