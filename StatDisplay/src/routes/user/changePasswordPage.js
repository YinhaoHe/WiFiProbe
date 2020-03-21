/**
 * Created by yyy on 2017/8/25.
 */
import React, {PropTypes} from 'react';
import { connect } from 'dva';
import ChangePasswordForm from '../../components/login/ChangePasswordForm';

function ChangePasswordPage({location, dispatch}) {

  const changePasswordProps = {
    onChangePassword(fieldValue){
      dispatch({
        type: 'app/changePassword',
        payload: {...fieldValue},
      });
    }
  };

  return (
    <ChangePasswordForm {...changePasswordProps}/>
  );
}


ChangePasswordPage.propTypes={
  app: PropTypes.object,
  location: PropTypes.object,
  dispatch: PropTypes.func,

};

function mapStateToProps({}){
  return {};
}

export default connect(mapStateToProps)(ChangePasswordPage);
